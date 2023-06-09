package Verticle;

import Utils.Constants;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import Database.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseVerticle extends AbstractVerticle
{
    static CustomConnectionPool connectionPool;

    static
    {
        connectionPool = CustomConnectionPool.getInstance(4);

        connectionPool.setURL(PropertiesFile.getURL());

        connectionPool.setUser(PropertiesFile.getUSER());

        connectionPool.setPassword(PropertiesFile.getPASSWORD());

        connectionPool.createConnectionPool();
    }

    EventBus eventBus;
    @Override
    public void start(Promise<Void> startPromise) throws Exception
    {
        eventBus = vertx.eventBus();

        eventBus.consumer(Constants.DISCOVERY_ADD_DEVICE, handler->
        {
            JsonObject deviceDetails = (JsonObject) handler.body();

            if(AddDevice(deviceDetails).succeeded())
            {
                handler.reply("Discovery Device added in Database");
            }
            else
            {
                handler.reply("Some issue in adding Discovery Device in Database");
            }
        });

        eventBus.consumer(Constants.DISCOVERY_EDIT_DEVICE, handler->
        {
            JsonObject deviceDetails = (JsonObject) handler.body();

            if(EditDevice(deviceDetails).succeeded())
            {
                handler.reply("Discovery Device information edited in Database");
            }
            else
            {
                handler.reply("Some issue in editing Discovery Device information in Database");
            }
        });


        eventBus.consumer(Constants.DISCOVERY_GET_ALL_DEVICE,handler->
        {
            loadData().onComplete(result->
            {
                if(loadData().succeeded())
                {
                    handler.reply(new JsonArray(loadData().result()));
                }
                else
                {
                    handler.reply("Enable to fetch the Discovery Data from Database");
                }
            });
        });


        eventBus.consumer(Constants.DISCOVERY_DELETE_DEVICE,handler->
        {
            System.out.println(handler.body());

           DeleteDevice(handler.body().toString()).onComplete(result->
           {
              if(DeleteDevice(handler.body().toString()).succeeded())
              {
                  handler.reply("Device deleted successfully");
              }
              else
              {
                  handler.reply("Enbale to delete discovery Device");
              }
           });
        });


        eventBus.consumer(Constants.RUN_DISCOVERY,handler->
        {
            System.out.println(handler.body());

            discovery(handler.body().toString()).onComplete(result->
            {

                eventBus.request(Constants.RUN_DISCOVERY_SPAWN_PEROCESS,discovery(handler.body().toString()).result(),response->
                {
                    if(response.succeeded())
                    {
                        String deviceId = response.result().body().toString();

                        if(updateDiscovery(deviceId).succeeded())
                        {
                            System.out.println("Discovery Table Updated with Provision value");
                        }
                        else
                        {
                            System.out.println("Some Problem in Updating the Provision value");
                        }
                    }
                    else
                    {
                        System.out.println("Some error in getting the output from .exe file");
                    }
                });

                if(discovery(handler.body().toString()).succeeded())
                {
                    handler.reply("Device discovered successfully");
                }
                else
                {
                    handler.reply("Device not discovered");
                }
            });
        });


    }

    private Future<Boolean> DeleteDevice(String deviceID)
    {
        Promise<Boolean> promise = Promise.promise();

        Connection connection = connectionPool.getConnection();

        Operations operations = new Operations(connection);

        try
        {
           String whereClause = "DEVICEID = "+Integer.valueOf(deviceID);

            operations.delete("DISCOVERY_TABLE",whereClause);

            promise.complete(true);
        }
        catch (Exception exception)
        {
            promise.complete(false);

            exception.printStackTrace();
        }
        finally
        {
            connectionPool.releaseConnection(connection);
        }
        return promise.future();

    }

    private Future<JsonObject> discovery(String deviceID)
    {
        Promise<JsonObject> promise = Promise.promise();

        JsonObject credentialData = new JsonObject();

        Connection connection = connectionPool.getConnection();

        try
        {
            Operations operations = new Operations(connection);

            List<Map<String, Object>> allData = null;

            ArrayList<String> columns = new ArrayList<>();

            columns.add("IPADDRESS");

            columns.add("CREDENTIAL");

            columns.add("TYPE");

            String whereCluase = " WHERE DEVICEID = "+Integer.valueOf(deviceID);

            allData = operations.selectwithWhere("DISCOVERY_TABLE",columns,whereCluase);

            JsonObject credential = new JsonObject(allData.get(0).get("CREDENTIAL").toString());

            credentialData.put("username",credential.getValue("username"));

            credentialData.put("password",credential.getValue("password"));

            credentialData.put("ip",allData.get(0).get("IPADDRESS"));

            credentialData.put("type",allData.get(0).get("TYPE"));

            credentialData.put("id",Integer.valueOf(deviceID));

            promise.complete(credentialData);

        }
        catch (Exception exception)
        {
            promise.fail("Some Error in fetch the data to discover the device");

            exception.printStackTrace();
        }
        finally
        {
            connectionPool.releaseConnection(connection);
        }
        return promise.future();
    }



    private Future<List<Map<String,Object>>> loadData()
    {
        Promise<List<Map<String,Object>>> promise = Promise.promise();

        List<Map<String, Object>> allData = null;

        Connection connection = connectionPool.getConnection();
        try
        {

            Operations operations = new Operations(connection);

            ArrayList<String> columns = new ArrayList<>();

            columns.add("NAME");

            columns.add("IPADDRESS");

            columns.add("TYPE");

            columns.add("TAG");

            columns.add("DEVICEID");

            columns.add("PROVISION");

           allData = operations.select("DISCOVERY_TABLE",columns);

           promise.complete(allData);

        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            connectionPool.releaseConnection(connection);
        }

        return promise.future();
    }




    private Future<Boolean> AddDevice(JsonObject credentialData)
    {
        Promise<Boolean> promise = Promise.promise();

        Connection connection = connectionPool.getConnection();

        Operations operations = new Operations(connection);

        try
        {
            HashMap<String,Object> data = new HashMap<>();

            data.put("NAME",credentialData.getValue("name"));

            data.put("IPADDRESS",credentialData.getValue("ip"));

            data.put("TYPE",credentialData.getValue("type"));

            data.put("CREDENTIAL",(new JsonObject()
                    .put("username",credentialData.getValue("username"))
                    .put("password",credentialData.getValue("password"))).toString());

            data.put("TAG",credentialData.getValue("tag"));

            operations.insert("DISCOVERY_TABLE",data);

            promise.complete(true);
        }
        catch (Exception exception)
        {
            promise.complete(false);

            exception.printStackTrace();
        }
        finally
        {
            connectionPool.releaseConnection(connection);
        }
        return promise.future();
    }

    private Future<Boolean> updateDiscovery(String deviceID)
    {
        Promise<Boolean> promise = Promise.promise();

        Connection connection = connectionPool.getConnection();

        Operations operations = new Operations(connection);

        try
        {
            HashMap<String,Object> data = new HashMap<>();

            data.put("PROVISION",true);

            String whereClause = "DEVICEID = " + Integer.valueOf(deviceID);

            operations.update("DISCOVERY_TABLE",data,whereClause);

            promise.complete(true);

        }
        catch (Exception exception)
        {
            promise.complete(false);

            exception.printStackTrace();
        }
        finally
        {
            connectionPool.releaseConnection(connection);
        }
        return promise.future();
    }


    private Future<Boolean> EditDevice(JsonObject credentialData)
    {
        Promise<Boolean> promise = Promise.promise();

        Connection connection = connectionPool.getConnection();

        Operations operations = new Operations(connection);

        try
        {
            HashMap<String,Object> data = new HashMap<>();

            data.put("NAME",credentialData.getValue("name"));

            data.put("IPADDRESS",credentialData.getValue("ip"));

            data.put("TYPE",credentialData.getValue("type"));

            data.put("CREDENTIAL",(new JsonObject()
                    .put("username",credentialData.getValue("username"))
                    .put("password",credentialData.getValue("password"))).toString());

            data.put("TAG",credentialData.getValue("tag"));

            String whereClause = "DEVICEID = "+credentialData.getString("id");

            operations.update("DISCOVERY_TABLE",data,whereClause);

            promise.complete(true);
        }
        catch (Exception exception)
        {
            promise.complete(false);

            exception.printStackTrace();
        }
        finally
        {
            connectionPool.releaseConnection(connection);
        }
        return promise.future();
    }




}
