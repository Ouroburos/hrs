function initSetup() {
 
   getRoomTypes();   
   getRoomCaps();
   getNights(30);
   getRoomPriceMin();
   getRoomPriceMax();
   getRoomCheckinMin();
   getRoomCheckinMax();
   getAmenities();

}

function getRoomTypes() {

   var xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
          console.log("hey, running!");
          
          var rtypes = JSON.parse(xhr.responseText);
          var rtelem = document.getElementById("roomtypes");
          
         
          /* Setting a default for Room Type options */
          var nullOpt = document.createElement("option");  
          var nullAtt = document.createAttribute("value"); 
          nullAtt.value = "0";
          
          nullOpt.setAttributeNode(nullAtt);
          rtelem.appendChild(nullOpt);
          
          
          /* Building Room Type Options */
          for(var key in rtypes){ 
            
            var option = document.createElement("option");                 
            var rtname = document.createTextNode(rtypes[key]);         
            option.appendChild(rtname);     
            
            var att = document.createAttribute("value");       
            att.value = key;  
            option.setAttributeNode(att);
            
            rtelem.appendChild(option);  
          }
          
        }
      };
      xhr.open("GET", "/RestfulStayHotel/setupRT", true);
      xhr.send();

}

function getRoomCaps(){
 
   var xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
          console.log("hey, running!");
          
          var rcaps = JSON.parse(xhr.responseText);
          var rtelem = document.getElementById("cap");
          
         
          /* Setting a default for Room Type options */
          var nullOpt = document.createElement("option");  
          var nullAtt = document.createAttribute("value"); 
          nullAtt.value = "0";
          
          nullOpt.setAttributeNode(nullAtt);
          rtelem.appendChild(nullOpt);
          
          
          /* Building Room Type Options */
          for(var key in rcaps){ 
            
            var option = document.createElement("option");                 
            var rcap = document.createTextNode(rcaps[key]);         
            option.appendChild(rcap);     
            
            var att = document.createAttribute("value");       
            att.value = rcaps[key];  
            option.setAttributeNode(att);
            
            rtelem.appendChild(option);  
          }
          
        }
      };
      xhr.open("GET", "/RestfulStayHotel/setupCap", true);
      xhr.send();

}
function getRoomPriceMin(){

  var xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
          console.log("hey, running!");
          
          var minP = JSON.parse(xhr.responseText);
          var slider = document.getElementById("price");

              slider.min = Math.round(minP);

        }
      };
      xhr.open("GET", "/RestfulStayHotel/setupMinP", true);
      xhr.send();


}
function getRoomPriceMax(){

  var xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
          console.log("hey, running!");
          
          var maxP = JSON.parse(xhr.responseText);
          var slider = document.getElementById("price");

              slider.max = Math.round(maxP);
              
        }
      };
      xhr.open("GET", "/RestfulStayHotel/setupMaxP", true);
      xhr.send();

}
function getRoomCheckinMin(){

  var today = new Date();
  var dd = today.getDate();
  var mm = today.getMonth()+1;
  var yyyy = today.getFullYear();

  if(dd<10) {
      dd='0'+dd
  } 

  if(mm<10) {
      mm='0'+mm
  } 

  today = yyyy+'-'+mm+'-'+dd;

  var date = document.getElementById("checkin");
      date.min = today;

}
function getRoomCheckinMax(){

  var today = new Date();
  var dd = today.getDate();
  var mm = today.getMonth()+1;
  var yyyy = today.getFullYear();

  if(dd<10) {
      dd='0'+dd
  } 

  if(mm > 6){ 
   mm = 12 - (mm + 6);
   yyyy++;
  } else {
    mm +=6;
  }

  if(mm<10) {
      mm='0'+mm
  } 

  today = yyyy+'-'+mm+'-'+dd;

  var date = document.getElementById("checkin");
  date.max = today;

}
function getNights(num){

  
    var nights = document.getElementById("nights");
    
   
    /* Setting a default for Room Type options */
    var nullOpt = document.createElement("option");  
    var nullAtt = document.createAttribute("value"); 
    nullAtt.value = "0";
    
    nullOpt.setAttributeNode(nullAtt);
    nights.appendChild(nullOpt);
    
    
    /* Building Room Type Options */
    for(var i = 1; i <= num; i++){ 
      
      var option = document.createElement("option");                 
      var text = document.createTextNode(i);         
      option.appendChild(text);     
      
      var att = document.createAttribute("value");       
      att.value = i;  
      option.setAttributeNode(att);
      
      nights.appendChild(option);  
    }
          
     

}
function getAmenities(){

  var xhr = new XMLHttpRequest();
      xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
          console.log("hey, running!");
          
          var amns = JSON.parse(xhr.responseText);
          var amDiv = document.getElementById("amns-div");
          
          
          /* Building Room Type Options */
          for(var key in amns){ 
            
            var label = document.createElement("label");                 
            var text = document.createTextNode(amns[key]);
            label.appendChild(text);   

            var input = document.createElement("input");                    
            
            
            var att = document.createAttribute("type");       
            att.value = "checkbox"; 
            var att2 = document.createAttribute("id");       
            att2.value = "a"+key; 
            var att3 = document.createAttribute("value");       
            att3.value = key;     
            var att4 = document.createAttribute("name");       
            att4.value = "amenities"; 
            input.setAttributeNode(att);
            input.setAttributeNode(att2);
            input.setAttributeNode(att3);
            input.setAttributeNode(att4);

            label.appendChild(input);
            
            amDiv.appendChild(label);  

          }
          
        }
      };
      xhr.open("GET", "/RestfulStayHotel/setupAmns", true);
      xhr.send();

}

function removeMessages(){
  var messages = document.getElementById("messages");
  
  while (messages.firstChild) {
    messages.removeChild(messages.firstChild);
  }
}