export class Task {
    desc: string;
    creationDate: Date;
    dueDate: Date;
    color: string;
  
    constructor(object: { desc: string; creationDate: Date; dueDate: Date; color: string }) {
      this.desc = object.desc;
      this.creationDate = new Date(object.creationDate);
      this.dueDate = new Date(object.dueDate);           
      this.color = object.color;
    }
  
    getCreationDate(): string {
      const year = this.creationDate.getFullYear();
      const month = this.creationDate.getMonth() + 1;
      const day = this.creationDate.getDate();
      return `${year}-${month}-${day}`;
    }
  
    getDueDate(): string {
      const year = this.dueDate.getFullYear();
      const month = this.dueDate.getMonth() + 1;
      const day = this.dueDate.getDate();
      return `${year}-${month}-${day}`;
    }
}