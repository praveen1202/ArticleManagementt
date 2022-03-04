function modifyNavbar(){
    $("#form-entry").remove();
    $(".navbar-nav .log").remove();
    $(".navbar-nav .sign").remove();

    let $dropDownList = $("<li>",{"class":"nav-item dropdown"});
    let $userName = $("<a>",{"class":"nav-link dropdown-toggle","id":"navbarDropdown","role":"button","data-toggle":"dropdown","aria-haspopup":"true","aria-expanded":"false"});
    $userName.text("Profile");

    $dropDownList.append($userName);

    let $dropDownMenu = $("<div>",{"class":"dropdown-menu","aria-labelledby":"navbarDropdown"});
    let $menu_1 = $("<a>",{"class":"dropdown-item","href":"#"});
    $menu_1.text("Option 1");
    let $menu_2 = $("<a>",{"class":"dropdown-item","href":"#"});
    $menu_2.text("Option 2");
    let $dropDownDivider = $("<div>",{"class":"dropdown-divider"});
    let $menu_3 = $("<a>",{"class":"dropdown-item","href":"#"});
    $menu_3.text("Option 3");

    $dropDownMenu.append($menu_1);
    $dropDownMenu.append($menu_2);
    $dropDownMenu.append($dropDownDivider);
    $dropDownMenu.append($menu_3);

    $dropDownList.append($dropDownMenu);

    $(".navbar-nav").append($dropDownList);

    let $getPremiumForm = $("<form>",{"class":"form-inline","action":"apply-premium"});
    let $getPremium = $("<input>",{"class":"btn btn-outline","type":"submit","value":"Get Premium"});
    $getPremiumForm.append($getPremium);
    $(".navbar-nav").append($getPremiumForm);

    let $logOut = $("<form>",{"class":"form-inline logout","action":"log-out"});
    let $logOutTag = $("<input>",{"class":"btn btn-outline","type":"submit","value":"Log Out"});
    $logOut.append($logOutTag);

    $(".navbar-nav").append($logOut);
}

