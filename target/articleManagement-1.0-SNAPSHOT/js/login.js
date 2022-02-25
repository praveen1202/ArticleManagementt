function modifyNavbar(){
    $("#form-entry").remove();
    $(".navbar-nav .log").remove();
    $(".navbar-nav .sign").remove();

    let $logOut = $("<form>",{"class":"form-inline logout","action":"log-out"});
    let $logOutTag = $("<input>",{"class":"btn btn-outline","type":"submit","value":"Log Out"});
    $logOut.append($logOutTag);
    $(".navbar-nav").append($logOut);
}


if($("#session-name").val() !== ''){        //if user is logged in

    //have to add logout button
    $("#form-entry").remove();
    modifyNavbar();
}

