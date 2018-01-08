// HINT: Task 2
// We should map response to a class

/*
   A CarDetails class represent an instance of a car's details. This object needs
   to be used in conjunction with a Car object to fully describe a car.
   The following class attributes are mandatory to create an instance of
   CarDetails -
              id : Unique ID identifying the specific car.
              bodyTypes : List of body types of a specific car, e.x Coupe, wagon etc.
              transmissionTypes : List of transmission types, e.x Manual, Auto,
                                Sports Auto etc.
              fuelTypes : List of fuel types the car is designed to work with, e.x
                         Premium Unleaded Petrol, E10, Diesel etc.

    Any changes in the persistent object in the service layer should reflect
    in this class.
*/
//        //Body types: ${this._bodyType}\nTranmissions types: ${this._transmissionType}\nFuel types: ${this._fuelType}`;
'use strict';

export class CarDetails {
    constructor(id, bodyTypes, transmissionTypes, fuelTypes) {
        this._id = id;
        this._bodyTypes = bodyTypes;
        this._transmissionTypes = transmissionTypes;
        this._fuelTypes = fuelTypes;
    }

    get id() {
        return this._id;
    }

    get bodyTypes() {
        return this._bodyTypes;
    }

    get transmissionTypes() {
        return this._transmissionTypes;
    }

    get fuelTypes() {
        return this._fuelTypes;
    }

    getDetails() {
        return `ID: ${this._id} Body types:${this._bodyTypes} Transmission types: ${this._transmissionTypes} Fuel Types: ${this._fuelTypes}`;
    }

}
