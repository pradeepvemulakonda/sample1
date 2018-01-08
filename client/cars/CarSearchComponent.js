'use strict';

import {Car} from "../cars/Car";
import {CarService} from "../cars/CarService";
import {CarSearchResultComponent} from "./CarSearchResultComponent";


export class CarSearchComponent extends HTMLElement {
    constructor() {
        super();
    }

    createdCallback() {
        let template = `
            <style>
                .results, .no-results {
                    display: none;
                }

                h2 {
                    color: #174e88;
                }
                
                .show {
                    display: block;
                }

                .search-button {
                    display: inline-block;
                    background-color: #174e88;
                    padding: 2px 10px;
                    border: none;
                    color: #FFFFFF;
                    text-decoration: none;
                    font-size: 16px;
                    cursor: pointer;
                }

                .query {
                    font-size: 16px;
                }

                .results-list {
                    list-style-type: none;
                    padding: 0;
                    margin: 0;
                }
            </style>
            <div class="car-search">
                <h2>
                    Car Search
                </h2>
    
                <div class="search">
                    <label for="search">Search for a Car: </label>
                    <input type="search" name="query" id="search" class="query"
                    placeholder="Enter search query..." value="" />
                    <button class="search-button" type="button">Search</button>
                </div>
    
                <div class="results">
                    <h3>
                        Results
                    </h3>
    
                    <ul class="results-list">
                    </ul>
                </div>
                
                <div class="no-results">
                    <p>No results</p>
                </div>
            </div>
        `;

        this.innerHTML = template;

        this.search = this.querySelector('#search');
        this.searchButton = this.querySelector('.search-button');
        this.results = document.querySelector('.results');
        this.resultsNone = document.querySelector('.no-results');
        this.resultsList = document.querySelector('.results-list');

        this.carService = new CarService();
    };

    attachedCallback() {
        this.NewCarResultComponent = document.registerElement("car-result", CarSearchResultComponent);

        this.search.addEventListener(
            'keydown',
            (evt) => {
                if (this._queryChanged(evt)) {
                    let query = evt.target.value;
                    this._getResults(query);
                }
            },
            false
        );

        this.searchButton.addEventListener(
            'click',
            (evt) => {
                if (this._queryModified(evt)) {
                    let query = this.search.value;
                    this._getResults(query);
                }
            },
            false
        );
    }

    _queryChanged(evt) {
        const enterKeyCode = 13;

        if (evt.which !== enterKeyCode) {
            return;
        }

        let query = evt.target.value;

        if (query.trim().length === 0) {
            return;
        }

        this._getResults(query);
    }

    _queryModified(evt) {
        let query = this.search.value;

        if (query.trim().length === 0) {
            return;
        }

        this._getResults(query);
    }

    _getResults(query) {
        return this.carService.getCarList(query).then((cars) => {

            this.resultsList.innerHTML = '';

            if (cars.length === 0) {
                this.resultsNone.classList.add('show');
                this.results.classList.remove('show');
                return;
            }

            this.resultsNone.classList.remove('show');
            this.results.classList.add('show');

            cars.forEach((carResult) => {
                let car = new Car(
                    carResult.id,
                    carResult.makeName,
                    carResult.modelName,
                    carResult.rrp
                );

                let result = new this.NewCarResultComponent;
                result.properties = {car: car};
                this.resultsList.appendChild(result);
            });
        });
    };
}