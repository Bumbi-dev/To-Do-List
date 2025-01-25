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

    getTimeLeft(): string {
    	const now = new Date();

    	let seconds = Math.floor((this.dueDate.getTime() - now.getTime()) / 1000);
		const prefix = Math.sign(seconds);
		seconds = Math.abs(seconds);

    	const minutes = Math.floor(seconds / 60);
    	const hours = Math.floor(minutes / 60);
    	const days = Math.floor(hours / 24);
    	let months = (this.dueDate.getFullYear() - now.getFullYear()) * 12 + this.dueDate.getMonth() - now.getMonth();

		if (prefix < 0) {
			if (now.getDate() < this.dueDate.getDate()) months += 1;
		} else {
			if (now.getDate() > this.dueDate.getDate()) months -= 1;
		}

    	const years = Math.floor(months / 12);

		if(years >= 5)
			return prefix * years + " years";
    	if(years >= 1)
    	    return prefix * months + " months";
    	if(days >= 1)
    	    return prefix * days + " days";
    	if(hours >= 1)
    	    return prefix * hours + " hours";
    	if(minutes >= 1)
    	    return prefix * minutes + " minutes";
      
    	return prefix * seconds + " seconds";
    }
}