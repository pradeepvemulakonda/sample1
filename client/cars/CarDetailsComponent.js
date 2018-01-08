'use strict';

export class CarDetailsComponent extends HTMLElement {
    constructor() {
        super();
    }

    createdCallback() {
        let template = `
         <style>

            .details-block {
                display: none;
            }

            .car-id, .car-body-types, .car-transmission-types, .car-fuel-types{
                border: 1px solid #ddd;
                margin-top: -1px;
                background-color: #f6f6f6;
                padding:12px;
                text-decoration: none;
                font-size: 16px;
                color: black;
                display: block;
                width: 600px;
            }

            .show {
                display: block;
            }

        </style>
            <div class="details">
                <h2>
                    Car Details
                </h2>
                <div class="details-block">
                    <div class="car-id">

                    </div>
                    <div class="car-body-types">

                    </div>
                    <div class="car-transmission-types">

                    </div>
                    <div class="car-fuel-types">

                    </div>
                </div>
            </div>
        `;

        this.innerHTML = template;

        this.carId = this.querySelector('.car-id');
        this.carBodyTypes = this.querySelector('.car-body-types');
        this.transmissionTypes = this.querySelector('.car-transmission-types');
        this.fuelTypes = this.querySelector('.car-fuel-types');
        this.detailsBlock = this.querySelector('.details-block');
    }

    set properties(props) {
        this.carDetails = props.carDetails;

        if (this.carDetails) {
            this.detailsBlock.classList.add('show');
        }

        // HINT: Task 2
        // Let's display the details once we get them

        this.carId.innerHTML = 'ID: ' + this.carDetails._id;
        this.carBodyTypes.innerHTML = 'Body types: '+ this.carDetails._bodyTypes.join(' ');
        this.transmissionTypes.innerHTML = 'Transmission types: '+ this.carDetails._transmissionTypes.join(' ');
        this.fuelTypes.innerHTML = 'Fuel types: '+ this.carDetails._fuelTypes.join(' ');
    }

}
