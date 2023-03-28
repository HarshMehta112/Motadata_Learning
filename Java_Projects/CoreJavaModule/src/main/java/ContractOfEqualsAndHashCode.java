public class ContractOfEqualsAndHashCode
{
    ContractOfEqualsAndHashCode(int x)
    {

    }
    boolean test(ContractOfEqualsAndHashCode p,ContractOfEqualsAndHashCode q)
    {
        return p.equals(q) ? true : false;
    }

    public static void main(String[] args) {
        ContractOfEqualsAndHashCode obj = new ContractOfEqualsAndHashCode(2);

        ContractOfEqualsAndHashCode obj1 = new ContractOfEqualsAndHashCode(3);

        ContractOfEqualsAndHashCode obj2 = new ContractOfEqualsAndHashCode(2);

        //System.out.println(test(obj,obj1));
    }


}
