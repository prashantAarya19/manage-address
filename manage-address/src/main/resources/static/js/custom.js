
//plan info
function include(id) {
  var element = document.getElementById(id);
  element.classList.toggle("active");
}

//address info
function address(id) {
  var element = document.getElementById(id);
  element.classList.add("active");
}
function addressOK(id) {
  var element = document.getElementById(id);
  element.classList.remove("active");
}

// billing address check
function yesnoCheck() {
  if (document.getElementById('noCheck').checked) {
      document.getElementById('ifYes').style.display = 'block';
  }
  else document.getElementById('ifYes').style.display = 'none';
}





