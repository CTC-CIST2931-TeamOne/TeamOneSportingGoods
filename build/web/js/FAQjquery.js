/*********************************************
    Name       : FAQStyle
    Created on : Oct 7, 2020, 2:42:10 PM
    Author     : Patricia Rivera
    I certify I wrote this code.
*********************************************/

$(function() {
  $("td[colspan=1]").find("p").hide();
  $("table").click(function(event) {
    event.stopPropagation();
    var $target = $(event.target);
    if ($target.closest("td").attr("colspan") > 1) {
      $target.slideUp();
    } else {
      $target.closest("tr").next().find("p").slideToggle();
    }
  });
});
