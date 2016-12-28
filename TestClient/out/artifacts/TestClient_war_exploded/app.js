$(document).ready(function() {
    $("#select1").change(changeValue1).change();
    $("#select2").change(changeValue2).change();
});

var e, what, how, value;

function changeValue1(){
    e = document.getElementById("select1");
    what = e.options[e.selectedIndex].value;
}

function changeValue2(){
    e = document.getElementById("select2");
    how = e.options[e.selectedIndex].value;
}

function searchButton() {
    var temp = document.getElementById('inputValue').value;
    value = temp.split(' ').join('+');
    if(value!=""){
        window.location.href = "/"+what+".jsp?"+how+"="+value;
        /*var http = new XMLHttpRequest();
        http.open("GET", "/"+what+".jsp?"+how+"="+value, true);
        http.send( null );
        return http.responseText;*/
    }
}