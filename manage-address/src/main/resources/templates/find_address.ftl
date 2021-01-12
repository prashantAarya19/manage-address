<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Address</title>
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@400;700;900&display=swap" rel="stylesheet">
    <link href="/css/manage_address.css" rel="stylesheet">
</head>

<body>
<div class="header">
    <img src="/images/logoFire.png" alt="">
</div>
<div class="pageDesc">
    <div class="container">
        <a style="color:#212121">back</a>
        <h1>Manage Address</h1>


        <div class="shadowBox clearfix">
            <div class="addressSec active" id="saved">
                <div class="address clearfix" >
                    <span class="fl mt15">Find Address</span>
                </div>
                <!-- Manage address start -->
                <div class="formGroup clearfix">
                    <div class="wid50">
                        <div class="value">
                            <select class="select" onchange="showDiv('locality1', this)">
                                <option>Find By</option>
                                <option>First Name</option>
                                <option>Last Name</option>
                            </select>
                            <div class="errorBox">Enter valid input</div>
                        </div>
                    </div>
                    <div class="wid50">
                        <div class="value">
                            <input type="text" class="inp">
                            <div class="errorBox">Enter valid input</div>
                        </div>
                    </div>
                </div>
                <div class="btnHolder">
                    <input type="button" value="Save"  class="btn">
                    <input type="button" value="Cancel"  class="btn2">
                </div>
                <!-- Manage Address End -->
            </div>
        </div>


    </div>
</div>

<div class="footer">
    <a href="#">Terms & Conditions</a>
    <a href="#">Privacy Policy</a>
    <a href="#">Cookie Policy</a>
</div>

<script src="/js/custom.js"></script>
</body>

</html>