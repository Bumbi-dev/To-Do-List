import './style.css'
import { Task } from './task.ts'

const list = document.getElementById("task-list") as HTMLElement
const child = document.getElementById("task-example")!.cloneNode(true) as HTMLElement

const req = await fetch("http://localhost:8080/closestTask")!
const resp = await req.json()

createTaskFromObject(resp)

function createTaskFromObject(taskObject: any) {
    const task = new Task(taskObject)
    child.classList.remove('hidden')
    
    child.querySelector(".desc")!.textContent = task.desc
    child.querySelector(".creation-date")!.textContent = task.getCreationDate()
    child.querySelector(".due-date")!.textContent = task.getDueDate()
    child.setAttribute("style", task.color);

    list.appendChild(child)
}