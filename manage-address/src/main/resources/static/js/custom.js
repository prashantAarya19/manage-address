    // for FAQ
    var acc = document.getElementsByClassName("accordion");
var i;

for (i = 0; i < acc.length; i++) {
acc[i].addEventListener("click", function() {
this.classList.toggle("active");
var panel = this.nextElementSibling;
if (panel.style.maxHeight) {
  panel.style.maxHeight = null;
} else {
  panel.style.maxHeight = panel.scrollHeight + "px";
} 
});
}

//faq view all
function faqAll() {
var y = document.getElementById("faqSec");
var x = document.getElementById("faqBtn");
if (x.innerHTML === "View more<span></span>") {
x.innerHTML = "View less<span></span>";
y.classList.add("active")
} else {
x.innerHTML = "View more<span></span>";
y.classList.remove("active")
}
}

//vendor Contact
function vendor() {
  var element = document.getElementById("contactNumber");
  element.classList.toggle("active");
}

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

// for other div in address form
function showDiv(divId, element)
{
    document.getElementById(divId).style.display = element.value == "other" ? 'block' : 'none';
}

 // for coupon tabs
 function coupon(evt, coupon) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
      tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(coupon).style.display = "block";
  evt.currentTarget.className += " active";
  }
  document.getElementById("defaultOpen").click();

