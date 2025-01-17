import './style.css'

const list = document.getElementById("task-list") as HTMLElement
const child = document.getElementById("task-example")!.cloneNode(true) as HTMLElement

const req = await fetch("http://localhost:8080/closestTask")!
const resp = await req.json()

createTaskFromObject(resp)

function createTaskFromObject(object: Object) {
    child.classList.remove('hidden')
    console.log(object)
    
    child.querySelector(".desc")!.textContent = object.desc
    child.querySelector(".creation-date")!.textContent = object.creationDate
    child.querySelector(".due-date")!.textContent = object.dueDate
    child.setAttribute("style", object.color);


    list.appendChild(child)
}