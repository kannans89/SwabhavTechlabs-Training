function es6() {
  let names = ["Manoj", "Varshil", "Umesh"];

  //spread operator
  //   console.log("Before updating " + names);
  //   let updatedNames = [...names, "Ramesh", "Sachin"];
  //   console.log("After updating " + updatedNames);

  //destructring

  //   var contact = {
  //     firstname: "Varshil",
  //     lastName: "Mehta",
  //     phone: "123456"
  //   };

  //   const { firstname, lastName } = contact;
  //   console.log("First name " + firstname);
  //   console.log("last name " + lastName);

  //Default function parametrs
  //   calculateArea = (height = 5, width = 4) => {
  //     console.log("Area is " + height * width);
  //   };

  //   calculateArea();

  //Template literals

  //   var fullName = `Full name is ${firstname} ${lastName}`;
  //   console.log(fullName);

  //multi line strings

  //   let multi = `Then took the other, as just as fair,
  //   And having perhaps the better claim
  //   Because it was grassy and wanted wear,
  //   Though as for that the`;
  //   console.log(multi);

  //es6 promises

  //   var wait2000 = new Promise((resolve, reject) => {
  //     setTimeout(resolve, 2000);
  //   }).then(() => {
  //     console.log("After 2s");
  //   });

  //   wait2000();

  //classes
}

class Person {
  constructor(name, phone) {
    this.name = name;
    this.phone = phone;
  }

  getName() {
    return this.name;
  }
}

class Student extends Person {
  constructor(name, phone, id) {
    super(name, phone);
    this.id = id;
  }
}

let student1 = new Student("Manoj", 12345, 121);
console.log(student1.getName());
