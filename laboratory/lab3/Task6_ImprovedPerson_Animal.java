// Task 6: Improved Person and Animal (Pet) with Interfaces

interface Identifiable {
    String getId();
    void setId(String id);
}

interface Ageable {
    int getAge();
    void haveBirthday();
}

class ImprovedPerson implements Comparable<ImprovedPerson>, Cloneable, Identifiable, Ageable {
    private String id;
    private String name;
    private int age;
    
    public ImprovedPerson(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String getId() { return id; }
    
    @Override
    public void setId(String id) { this.id = id; }
    
    @Override
    public int getAge() { return age; }
    
    @Override
    public void haveBirthday() { age++; }
    
    @Override
    public int compareTo(ImprovedPerson other) {
        return this.name.compareTo(other.name);
    }
    
    @Override
    public ImprovedPerson clone() {
        try {
            return (ImprovedPerson) super.clone();
        } catch (CloneNotSupportedException e) {
            return new ImprovedPerson(this.id, this.name, this.age);
        }
    }
    
    @Override
    public String toString() {
        return "Person{id='" + id + "', name='" + name + "', age=" + age + "}";
    }
}

interface Pet extends Identifiable, Ageable {
    String getName();
    void setName(String name);
    void play();
}

class ImprovedDog implements Pet {
    private String id;
    private String name;
    private int age;
    private String breed;
    
    public ImprovedDog(String id, String name, int age, String breed) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
    }
    
    @Override
    public String getId() { return id; }
    
    @Override
    public void setId(String id) { this.id = id; }
    
    @Override
    public int getAge() { return age; }
    
    @Override
    public void haveBirthday() { age++; }
    
    @Override
    public String getName() { return name; }
    
    @Override
    public void setName(String name) { this.name = name; }
    
    @Override
    public void play() {
        System.out.println(name + " the dog is fetching a ball!");
    }
    
    public void bark() {
        System.out.println(name + " says: Woof!");
    }
    
    @Override
    public String toString() {
        return "Dog{id='" + id + "', name='" + name + "', age=" + age + ", breed='" + breed + "'}";
    }
}