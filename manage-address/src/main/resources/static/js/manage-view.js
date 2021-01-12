$(document).ready(() => {
    $('#saved').append(operation);
    $(document).on('click','#add', () => toggleView(addAddress));
    $(document).on('click','#update', () => toggleView(updateAddress));
    $(document).on('click','#find', () => toggleView(findAddress));
    $(document).on('click','#remove', () => toggleView(deleteAddress));
    $(document).on('click','.btn2', () => toggleView(operation));
    $(document).on('click','#submit', () => submitForm());
    $(document).on('click','#findPerson', () => FindPerson());
    $(document).on('click','#update_person', () => updatePerson());
});

function toggleView(contentToShow) {
    $('#saved').empty();
    $('#saved').append(contentToShow);
}

function submitForm() {
    let data = [];
       data = {
           name : $('#name').val(),
           house : $('#house').val(),
           floor : $('#floor').val(),
           street : $('#street').val(),
           locality : $('#locality').val(),
           society : $('#society').val(),
           pincode : $('#pincode').val(),
           city : $('#city').val(),
           state : $('#state').val()
       };
       $.ajax({
           url : '/add',
           method : 'POST',
           contentType : 'application/json',
           dataType : 'json',
           data : JSON.stringify(data),
           success : function(response) {
               if(response) {
                   alert('Address saved successfully!');
                   toggleView(operation);
               } else {
                   alert('Something went wrong!');
               }
           },
           error: function (jqXHR, textStatus, errorThrown) {
               alert('Something went wrong!');
           }
       });
}

function FindPerson() {
   let path = '/find-one?attribute='+$( ".select option:selected").val()+'&value='+$( "#findVal").val();
       $.ajax({
           url : path,
           method : 'GET',
           success : function(response) {
               if(response) {
                   toggleView(updateAddress);
                   $('#name').val(response.firstName+' '+response.lastName);
                   $('#house').val(response.address.house)
                   $('#floor').val(response.address.floor)
                   $('#street').val(response.address.street)
                   $('#locality').val(response.address.locality)
                   $('#society').val(response.address.society)
                   $('#pincode').val(response.address.pinCode)
                   $('#city').val(response.address.city)
                   $('#state').val(response.address.state)
               } else {
                   alert('Something went wrong!');
               }
           },
           error: function (jqXHR, textStatus, errorThrown) {
               alert('Something went wrong!');
           }
       });
}

function updatePerson() {
    let data = [];
       data = {
           name : $('#name').val(),
           house : $('#house').val(),
           floor : $('#floor').val(),
           street : $('#street').val(),
           locality : $('#locality').val(),
           society : $('#society').val(),
           pincode : $('#pincode').val(),
           city : $('#city').val(),
           state : $('#state').val()
       };
       $.ajax({
           url : '/update',
           method : 'POST',
           contentType : 'application/json',
           dataType : 'json',
           data : JSON.stringify(data),
           success : function(response) {
               if(response) {
                   alert('Address saved successfully!');
                   toggleView(operation);
               } else {
                   alert('Something went wrong!');
               }
           },
           error: function (jqXHR, textStatus, errorThrown) {
               alert('Something went wrong!');
           }
       });
}




