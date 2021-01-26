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
    $(document).on('click','#removePerson', () => removePerson());
});

function toggleView(contentToShow) {
    $('#saved').empty();
    $('#saved').append(contentToShow);
}

function submitForm() {
    if(isEmpty()) {
        alert('Every field is mandatory');
        return;
    }
    let data = [];
       data = {
           name : $('#name').val(),
           email : $('#email').val(),
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
           dataType : 'json',
           success : function(response) {
               if(response.success) {
                   toggleView(updateAddress);
                   $('#name').val(response.data.name);
                   $('#email').val(response.data.email);
                   $('#house').val(response.data.address.house)
                   $('#floor').val(response.data.address.floor)
                   $('#street').val(response.data.address.street)
                   $('#locality').val(response.data.address.locality)
                   $('#society').val(response.data.address.society)
                   $('#pincode').val(response.data.address.pinCode)
                   $('#city').val(response.data.address.city)
                   $('#state').val(response.data.address.state)
               } else {
                   alert('Person not available!');
                   toggleView(operation);
               }
           },
           error: function (jqXHR, textStatus, errorThrown) {
               alert('Something went wrong!');
           }
       });
}

function updatePerson() {
    if(isEmpty()) {
            alert('Every field is mandatory');
            return;
    }
    let data = [];
       data = {
           name : $('#name').val(),
           email : $('#email').val(),
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
           method : 'PUT',
           contentType : 'application/json',
           dataType : 'json',
           data : JSON.stringify(data),
           success : function(response) {
               if(response) {
                   alert('Address updated successfully!');
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

function removePerson() {
    let path = '/delete-one?attribute='+$( ".select option:selected").val()+'&value='+$( "#removeVal").val();
       $.ajax({
           url : path,
           method : 'DELETE',
           success : function(response) {
               if(response) {
                   alert('Person removed successfully!');
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

function sliceInput(elm) {
    let value = $(elm).val();
    let maxLen = $(elm).prop('maxlength');
    if(value.length > maxLen) {
        $(elm).val(value.slice(0, maxLen));
    }
}

function isEmpty() {
    if($('#name').val() == '' ||
    $('#email').val() == '' ||
    $('#house').val()== '' ||
    $('#floor').val()== '' ||
    $('#street').val()== '' ||
    $('#locality').val()== '' ||
    $('#society').val()== '' ||
    $('#pincode').val()== '' ||
    $('#city').val()== '' ||
    $('#state').val()== '' ||) {
        return true;
    }
    return false;
 }




