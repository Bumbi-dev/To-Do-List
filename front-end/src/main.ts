import './style.css'
import { Task } from './task.ts'

const list = document.getElementById("task-list") as HTMLElement

await initTasks()

async function initTasks() {
    const req = await fetch("http://localhost:8080/tasks")!
    const resp = await req.json()

    for (let i = 0; i < resp.length; i++) {
      createTaskFromObject(resp[i]);
    }
}

function createTaskFromObject(taskObject: any): boolean {
    const child = document.getElementById("task-example")!.cloneNode(true) as HTMLElement;
    const task = new Task(taskObject);
    
    child.classList.remove('hidden');
    
    child.querySelector(".desc")!.textContent = task.desc;
    child.querySelector(".creation-date")!.textContent = task.getCreationDate();
    child.querySelector(".due-date")!.textContent = task.getDueDate();
    child.setAttribute("style", `color: ${task.color};`);

    list.appendChild(child);
    return true;
}