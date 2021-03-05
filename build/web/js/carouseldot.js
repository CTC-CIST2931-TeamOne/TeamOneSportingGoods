//Done by edrey


function currentSlide(n) {
       showSlides(slideIndex = n);
   }
//n is the # of image number in order
   function showSlides(n) {
       var i;
       // grabs the image using the class c_image 
       var slides = document.getElementsByClassName("c_image");
       // grabs the class carousel-dot in the span element
       var dots = document.getElementsByClassName("carousel-dot");
       
       // If # is larger than the current images than it will start at the first img always
       if (n > slides.length) {
           slideIndex = 1
       }
       if (n < 1) {
           slideIndex = slides.length
       }
       //loops thru all images
       for (i = 0; i < slides.length; i++) {
           slides[i].style.display = "none";
       } // doesnt display them out of the carousel each clicked
       //loops thru all dots
       for (i = 0; i < dots.length; i++) {
           dots[i].className = dots[i].className.replace("active", "");
       }
       
       slides[slideIndex - 1].style.display = "block";
       
       //show dot solid gray when is clicked
       //dots[slideIndex - 1].className += " active";
   } 