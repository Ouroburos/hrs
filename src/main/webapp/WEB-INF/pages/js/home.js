(function(){
	 
	
	//this determines what we need
	var changed = { ci:0, n:0, rt:0, cap:0, p:0};
	
	//global variable of possible rooms that we can book
	var rooms = null;

  //global variable of possible rooms that we can book
  var amenitiesMap = null;
	
//----------------Page loading setup----------------------
//////////////////////////////////////////////////////////
if(!document.getElementById("roomtypes").hasChildNodes())
     initSetup();
      
/////////////////////////////////////////////////////////////
// MAKE A MESSAGE FUNCTION TO RUN WITH EVERY RETURN - IF NULL

function selectRoomType() {

  removeMessages();
    
    //get the object that had the event called on it
    switch(this.name) {
    case "roomtypes":
    	changed.rt++;
        break;
    case "price":
    	changed.p++;
        break;
    case "cap":
    	changed.cap++;
        break;
    case "checkin":
    	changed.ci++;
        break;
    case "nights":
    	changed.n++;
        break;
    }
    
    var xhr = new XMLHttpRequest();
    
    //build POST data to send
    var params = {};
    
    if(changed.rt > 0){
       params.roomtype = document.getElementById("roomtypes").value; 
       console.log("sending roomtypes");
    }
    else{
       params.roomtype = 0; 
    }
    if(changed.p > 0){
       params.maxPrice = document.getElementById("price").value; 	
       console.log("sending price");
    }
    else{
 	   params.maxPrice = 0; 
    }
    if(changed.cap > 0){
       params.capacity = document.getElementById("cap").value;
       console.log("sending cap");
    }
    else{
 	   params.capacity = 0; 
    }
    if(changed.ci > 0){
       params.checkIn = document.getElementById("checkin").value;
       console.log("sending checkin");
    }
    else{
  	   params.checkIn = 0; 
     }
    if(changed.n > 0){
       params.nights = document.getElementById("nights").value; 
       console.log("sending nights");
    }
    else{
  	   params.nights = 0; 
     }

       params.amenities = []; //starting with empty array

    var amenities = document.getElementsByName("amenities");
    for (var i = 0; i < amenities.length; i++) {
      console.log(amenities[i].value);
      if(amenities[i].checked){
        console.log('this is checked');
        params.amenities.push(amenities[i].value);
      }
    };
       console.log(params.amenities);
    xhr.onreadystatechange = function(){
      if(xhr.readyState == 4 && xhr.status == 200){

    	//will be a list of room ids
        rooms = JSON.parse(xhr.responseText); 
        
        //
        if(rooms == null) {
          noAvailableRooms();
        }
        else {
          showRooms(rooms);
        }
      }
    };
    console.log(params);
    xhr.open("POST", "/RestfulStayHotel/rByType", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(params));

 }

function noAvailableRooms(){
	console.log('rooms is null');
  var submit = document.getElementById("submit-button");
  submit.disabled = true;

  var messages = document.getElementById("messages");
  var p = document.createElement("p");
  var text = document.createTextNode("We're sorry, there are no rooms available with your criteria at this time! ");         
      p.appendChild(text);  
    var classAtt = document.createAttribute("class"); 
    classAtt.value = "active";
    
    p.setAttributeNode(classAtt);
    messages.appendChild(p);

}

function checkValidReservation(){
  var isAuthenticated = document.getElementById("authenticated");
  if(isAuthenticated == null){
    alert("Create an account or log in to make a reservation.");
  }

  var nights = document.getElementById("nights");
  if(nights.value == 0){
    alert("Must have nights.");
  }

}

function showRooms(rooms){
  
  for (var key in rooms) {
    console.log("Key: " + typeof(key));
    console.log("Value: " + rooms[key]);
  };

}
  //setting event handlers
  document.getElementById("roomtypes").addEventListener("change", selectRoomType); 
  document.getElementById("price").addEventListener("change", selectRoomType); 
  document.getElementById("cap").addEventListener("change", selectRoomType); 
  document.getElementById("checkin").addEventListener("change", selectRoomType); 
  document.getElementById("nights").addEventListener("change", selectRoomType); 
  document.getElementById("submit-button").addEventListener("click", checkValidReservation); 
})();