$(function()
{
   var URL = "https://pokeapi.co/api/v2/pokemon/ditto";

   $.getJSON(URL).done(function (data)
   {
      console.log(data);
      $.each(data.pokemon,function (index,pokemon)
      {
         var name = pokemon.name.charAt(0).toUpperCase() + pokemon.name.slice(1);
         var par  = $("<p>").html(index);
         par.appendTo("#pokemon");
      })
   })
}

);