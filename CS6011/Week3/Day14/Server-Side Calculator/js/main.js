<html>
  <head>
    <style>
      textarea{

    }

      let xTA = document.getElmentById("xTA")
      xTA.addEventlistener(
    </style>
    </head>
<body style"background- color: lightblue">

</body>
</html>
let wsOpen = false;
function handleConnectCB(){
  wsOpen = true;
}
function handleConnectCB{
  wsResult
}

function  handleKeyPressCB(){
  resultTA.value = this.response
}

function handleKeyPressCB( event) {
  if (evet.type == "click" || event.keyCode == 13) {
    let x = parseFloat(xTa.value);
    if (isNaN(x)) {
      alert(" please make sure x is a number");
      xTA.value = "<Enter a Number>";
      xTA.select();
      event.preventDefault();
      return;
    }
    let x = parseFloat(xTa.value);
    if (isNaN(y)) {
      alert(" please make sure x is a number");
      yTA.value = "<Enter a Number>";
      yTA.select();
      event.preventDefault();
      return;
    }
    let request = XMLHttpRequest();
    request.open("GET", "http:// localhost:8080/calculate?x=" + x + "&y=" + y);
    request.addEventListener("error", handleAjaxErrorCB);
    request.addEventListener("load", handleAjaxSuccessCB);
    request.send();

    if (wsOpen) {
      ws.send(x + " " + y);
    } else {
      wsResultTA.value = "WS is not open ..."
    }

    //resultTA.value = (x + y);
  }
}

}
let xTA = document.getElementById("xTA");
let yTA = document.getElementById("yTA");
let resultTA = document.getElementById("resultTA");
xTA.addEventListener("keypress",handleKeyPressCB);
yTA.addEventListener("keypress",handleKeyPressCB);




// create the websocket
let ws =  new WebSocket("ws://localhost:8080")
ws.onopen = handleKeyPressCB;
ws.onmessage
