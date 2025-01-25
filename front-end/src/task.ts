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
    	const seconds = Math.floor((this.dueDate.getTime() - now.getTime()) / 1000);
    	if(seconds < 0)
    		return this.getTimePassed(seconds);

    	const minutes = Math.floor(seconds / 60);
    	const hours = Math.floor(minutes / 60);
    	const days = Math.floor(hours / 24);
    	let months = (this.dueDate.getFullYear() - now.getFullYear()) * 12 + this.dueDate.getMonth() - now.getMonth();
    	if(now.getDate() > this.dueDate.getDate())
    	    months -= 1;
    	const years = Math.floor(months / 12);

    	if(years >= 1)
    	    return months + " months";
    	if(days >= 1)
    	    return days + " days";
    	if(hours >= 1)
    	    return hours + " hours";
    	if(minutes >= 1)
    	    return minutes + " minutes";
      
    	return seconds + " seconds";
    }

    getTimePassed(seconds: number): string {
		const now = new Date();
		const minutes = Math.ceil(seconds / 60);
      	const hours = Math.ceil(minutes / 60);
      	const days = Math.ceil(hours / 24);
      	let months = (this.dueDate.getFullYear() - now.getFullYear()) * 12 + this.dueDate.getMonth() - now.getMonth();
      	if(now.getDate() < this.dueDate.getDate())
        	months += 1;
      	const years = Math.ceil(months / 12);
		
		if(years <= -1)
			return months + " months";
	
		if(days <= -1)
			return days + " days";
	
		if(hours <= -1)
			return hours + " hours";
	
		if(minutes <= -1)
			return minutes + " minutes";
	
		return seconds + " seconds";
    }
}