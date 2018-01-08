# Assignment

We are building out a car website to enable users to find the car they want quickly!

This assignment involves improving on our search capabilities.

This is a very simple assignment and we do not expect you to overcomplicate things. There are some optional
tasks that you can do additionally if you wish, but they are *not* imperative.


### Important Notes

* design is not important, functionality is key here, but feel free to revisit at the end
* only edit files inside `client` and `services` folders
* spend no more than 2-4 hours on this task
* feel free to utilize a version control tool such as `git`

### Support

If you have any questions, please don't hesitate to contact [dev at motome.com.au](mailto:dev@motome.com.au)

---

### Requirements

* Node >= 6.9.4
* Java 1.8
* Gradle 3.3

#### 1. Setup

1. Client: `npm install`
2. Services: `gradle build`

#### 2. Build

1. Client: `npm run build`
2. Services `gradle build`

#### 3. Running

1. Client: `npm start`
2. Services: `gradle run`

#### 4. Testing

1. Client: `npm test`
2. Services: `gradle build test`

---

## Tasks

Below are the tasks you must complete. 

We recommend reading them entirely before commencing and paying close attention to the notes below.

### Task 1: Sorting search results

As a user, I want to see the search results in a relevant order.

The results should be ordered alphabetically by `makeName` and then ascending by `rrp`.

#### Scenario 1

I visit [http://localhost:3000/api/cars?query=f](http://localhost:3000/api/cars?query=f) in my browser and I see the following results:

```json
[{
    id: 10004,
    makeName: "Ferrari",
    modelName: "FF",
    rrp: 624646
}, {
    id: 10002,
    makeName: "Ford",
    modelName: "Fiesta",
    rrp: 15825
}, {
    id: 10003,
    makeName: "Ford",
    modelName: "Focus",
    rrp: 23390
}, {
    id: 10001,
    makeName: "Ford",
    modelName: "Falcon",
    rrp: 29890
}]
```

#### Scenario 2

I visit the [http://localhost:3000/](http://localhost:3000/) in my browser and I see a search box.
In the searchbox, I input 'f', press enter and I see the following results:

* Ferrari FF ($624646)
* Ford Fiesta ($15825)
* Ford Focus ($23390)
* Ford Falcon ($29890)

### Task 2: Getting car details

As a user I want to see more information about the car I have selected.

#### Scenario 1

Please build this as an API endpoint as such: '/api/cars/{id}'

When I visit 'http://localhost:3000/api/cars/10004' in my browser, I see the following result:

```json
{
    id: 10004,
    bodyTypes: [
        "COUPE"
    ],
    transmissionTypes: [
        "AUTO"
    ],
    fuelTypes: [
        "PREMIUM UNLEADED PETROL"
    ]
}
```

#### Scenario 2

I visit the [http://localhost:3000/](http://localhost:3000/) in my browser and I see a search box.
In the searchbox, I input 'ff', press enter and I see the following results:

* Ferrari FF ($624646)

I click on this result and see the following details update in the `Car Details` section:

```text
ID: 10004
Body types: COUPE
Tranmissions types: AUTO
Fuel types: PREMIUM UNLEADED PETROL
```

#### Scenario 3

With the previous car details still on the screen, in the searchbox I input 'focus', press enter and I see the following results:

* Ford Focus ($23390)

I click on this result and see the following details update in the `Car Details` section:

```text
ID: 10004
Body types: HATCH SEDAN
Tranmissions types: AUTO MANUAL
Fuel types: PREMIUM UNLEADED PETROL PREMIUM UNLEADED PETROL
```

### The above test case is not valid as the ID of ford focus is 10003 and not 10004 in the service layer.

### Optional Tasks

These tasks are absolutely optional:

* unit and/or integration tests
* have fun with the design i.e., group search results by makes

### Submission

Please zip and submit all working assignments to [dev at motome.com.au](mailto:dev@motome.com.au)
