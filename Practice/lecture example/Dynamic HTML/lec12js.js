function load_server(){
    let req = new XMLHttpRequest()
    req.open("get","lICENSE.txt");
    req.send();
    req.omload = function (){
        document.getElementById("display_fromserver").innerHTML = responseText;
    }
}



setInterval(display_time,1000)
function display_time(){
    const time_display = document.getElementById("display_time");
    const time_elapsed = new Date().getTime();
    const time_future = new Date("12 07,2022 13:00:00")
    const distance = time_future-time_future;
     let days = Math.floor(distance/(1000*60*60*24));
     let hours = Math.floor((distance%(1000*60*60*24))/(1000*60*60));
     let minutes = Math.floor((distance%(1000*60*60*24))/(1000*60));
    const seconds = Math.floor((distance%(1000*60))/1000);
    document.getElementById("display_time").innerHTML=days+"d"+hours+"h"+minutes+"M"+seconds+"s";

}




function validateform(){
    const age_value = document.getElementById("age");
    if (age_value.value <18){
        alert("Age should be greater than 18")
    }

                      }




const btn1 = document.getElementById("btn_inc");
btn1.addEventlistener("click",change_par);

const btn2 = document.getElementById("btn_rest");
// btn1.addEventlistener("click",function(){
//   document.body.style.backgroundColor = " blue"
// });
btn2.onclick=reset;

function change_par()
{
  const main_para = document.getElementById("main_par");
  main_para.style.fontSize = "22px";
  main_para.style.color = "blue";
}

function reset()
{
  const main_para = document.getElementById("main_par");
   main_para.style="12px";
   main_para.style.color = "red";
}
