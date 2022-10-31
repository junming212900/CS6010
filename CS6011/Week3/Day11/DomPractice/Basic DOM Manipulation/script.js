const body = document.body
body.append(" Hello World ")
const div = document.createElement("div")
//div.innerText= "hello world2" //show the txt in js

// div.textContent = "Hello World 2"// other way to show txt in js
div.innerHTML = "<strong>Hello World 3</strong>"// write text use html in js
body.append(div)
const strong = document.createElement("strong")
strong.innerText = " hello world 2"
body.append(strong)// more sectrity way to show the bold text.
