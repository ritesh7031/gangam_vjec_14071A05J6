import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		if(this.students!=null)
			return students;

		return null;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null)
			throw new IllegalArgumentException();
		else
		{
		for(int i=0,j=this.students.length;i<students.length;i++,j++)
		{
			this.students[j]=students[i];
		}
		}
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		else
			return students[index];
		//return null;
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		if (student == null) 
			throw new IllegalArgumentException();
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		students[index]=student;

	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		if (student == null) 
			throw new IllegalArgumentException();
		for(int i=students.length;i>=0;i--)
		{
			students[i+1]=students[i];
		}
		students[0]=student;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if (student == null) 
			throw new IllegalArgumentException();
		students[students.length]=student;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if (student == null) 
			throw new IllegalArgumentException();
		if(index<0||index>students.length)
			throw new IllegalArgumentException();
		for(int i=students.length;i>=index;i--)
		{
			students[i+1]=students[i];
		}
		students[index]=student;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		int i;
		if(index<0||index>students.length)
			throw new IllegalArgumentException();
		for( i=index;i<students.length;i++)
		{
			students[i]=students[i+1];
		}
		students[i]=null;
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		
		if (student == null) 
			throw new IllegalArgumentException();
		int index=-1,i ;
		for(i=0;i<students.length;i++){
			if(students[i]==student)
			{	index=i;break;
			}

		}
		if(index==-1)
			throw new IllegalArgumentException("Student not exist");
		else{
		for(i=index;i<students.length;i++)
		{
			students[i]=students[i+1];
		}
		students[i]=null;}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		if(index<0||index>students.length)
			throw new IllegalArgumentException();
		for(int i=index+1;i<students.length;i++)
		{
			students[i]=null;
		}

	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implement ation here
		if (student == null) 
			throw new IllegalArgumentException();
		int index=-1 ;
		for(int i=0;i<students.length;i++){
			if(students[i]==student)
			{	index=i;break;
			}

		}
		if(index==-1)
			throw new IllegalArgumentException("Student not exist");
		else{
		for(int i=index+1;i<students.length;i++)
		{
			students[i]=null;
		}
		}

	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		int j,i;
		if(index<0||index>students.length)
			throw new IllegalArgumentException();
		for(i=index,j=0;i<students.length;i++,j++)
		{
			students[j]=students[i];
		}
		for( i=j;i<students.length;i++)
		{
			students[i]=null;
		}

	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		int j,i;
		if (student == null) 
			throw new IllegalArgumentException();
		int index=-1 ;
		for( i=0;i<students.length;i++){
			if(students[i]==student)
			{	index=i;break;
			}

		}
		if(index==-1)
			throw new IllegalArgumentException("Student not exist");
		else{

		for(i=index,j=0;i<students.length;i++,j++)
		{
			students[j]=students[i];
		}
		for( i=j;i<students.length;i++)
		{
			students[i]=null;
		}}
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		Student student1;
		for(int i=0;i<students.length-1;i++)
		{
			for(int j=i+1;i<students.length;j++)
		{
			if(students[i].compareTo(students[j])>0)
			{
					student1=students[i];
					students[i]=students[j];
					students[j]=student1;
			}
		}
		}

	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		Student[] s2=new Student[students.length];

		if(date==null)
			throw new IllegalArgumentException();
		for(int i=0,j=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().compareTo(date)==0)
				s2[j++]=students[i];
		}
		//if(s2!=null)
		return s2;
		//return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		Student[] s2=new Student[students.length];

		if(firstDate==null||lastDate==null)
			throw new IllegalArgumentException();
		for(int i=0,j=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().compareTo(lastDate)==0&&students[i].getBirthDate().compareTo(firstDate)==0)
				s2[j++]=students[i];
		}
		if(s2!=null)
		return s2;
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here

		if(date==null)
			throw new IllegalArgumentException();		
		Date d1=date;
		d1.setDate(date.getDate()+days);
		Date d2=date;
		d2.setDate(date.getDate()-days);
		int i,j;
		d1.setDate(date.getDate()+days);
				Student[] s2=new Student[students.length];
		for( i=0,j=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().compareTo(d1)==0 && students[i].getBirthDate().compareTo(d2)==0)
				s2[j++]=students[i];
		}
		//if(s2!=null)
		return s2;
	//	return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		if(indexOfStudent==0)
			throw new IllegalArgumentException();	
		return(2017-(int)students[indexOfStudent].getBirthDate().getYear());
//		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		Student[] s2=new Student[students.length];
		int i,j;
		for( i=0,j=0;i<students.length;i++)
		{
			if(age==(2017-(int)students[i].getBirthDate().getYear()))
				s2[j++]=students[i];
		}
		return s2;
	//	return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		int max=0,i,j;
		Student[] s2=new Student[students.length];
		for( i=0;i<students.length;i++)
		{
			if(students[i].getAvgMark()>max)
				max=(int) students[i].getAvgMark();
		}
		for( i=0,j=0;i<students.length;i++)
		{
			if(students[i].getAvgMark()==max)
				s2[j++]=students[i];
		}
		//if(s2!=null)
		return s2;
		//return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		int i;
		if(student==null)
			throw new IllegalArgumentException();		
		for( i=0;i<students.length;i++){
			if(students[i]==student)
			{	break;
			}

		}
		if(i<students.length-1)
			return(students[i+1]);
		return null;
	}
}
