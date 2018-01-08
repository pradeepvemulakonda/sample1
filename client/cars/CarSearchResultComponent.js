'use strict';

import {CarService} from "../cars/CarService";
import {CarDetails} from "../cars/CarDetails";

export class CarSearchResultComponent extends HTMLElement {
    constructor() {
        super();
    }

    createdCallback() {
        let template = `
            <style>
                .car-result {
                    cursor: pointer;
                    border: 1px solid #ddd;
                    margin-top: -1px;
                    background-color: #f6f6f6;
                    padding: 12px;
                    text-decoration: none;
                    font-size: 16px;
                    color: black;
                    display: block;
                    width: 400px;
                }
                .car-result:hover {
                    text-decoration: underline;
                }
            </style>
            <li class="car-result">

            </li>
        `;

        this.innerHTML = template;

        this.result = this.querySelector('li');
        this.carService = new CarService();
    }

    attachedCallback() {
        this.result.innerHTML = this.car.getDetails();
        this.result.addEventListener(
            'click', () => {
                this._onResultClick(this.car);
            },
            false
        );
    }

    attributeChangedCallback() {

    }

    set properties(props) {
        this.car = props.car;
    }

    _onResultClick(car) {
        let carDetailsSection = document.querySelector('car-details');

        // HINT: Task 2
        // We need to fetch the car details here to pass in more than just the ID!
        return this.carService.getCarDetails(car._id).then((carDtls) => {

          let carDetails = new CarDetails(
              carDtls.id,
              carDtls.bodyTypes,
              carDtls.transmissionTypes,
              carDtls.fuelTypes
          );
        carDetailsSection.properties = {
            carDetails: carDetails
        };
      });
    }
}
