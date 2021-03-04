// done by edrey
var index = 0;
  var images = document.getElementsByClassName("c_image");// grabs the image from the class
  var time;

autoSlides();//calling the function

function autoSlides() {
    for (var i = 0; i < images.length; i++) {
        images[i].style.display = "none";// only loops all images and displays only the first one not all
    }
    index++;
    // if the image idex is greater than the # imgs then restart at the 1st img
    if (index > images.length) {
      index = 1
    }
    
    //show img everytime slide changes 
    images[index-1].style.display = "block";
    time = setTimeout(autoSlides, 5000);
}

function currentImage(num) {
    for (var i = 0; i < images.length; i++) {
        images[i].style.display = "none";
    }
    index = num;
    images[num-1].style.display = "block";
    time = setTimeout(autoSlides, 5000);
}

//----------manually changing slides
function manualSwitch(n) {
  clearTimeout(time);
  var newIndex = index + n;
  if(newIndex <= images.length && newIndex > 0 ){
     currentImage(newIndex);
  }
  else if (newIndex < 1) {
    newIndex = images.length
currentImage(newIndex);
  }
  else {
    currentImage(1);
  }

}
