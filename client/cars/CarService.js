'use strict';

export class CarService {

    getCarList(query) {
        return fetch('/api/cars?query=' + query)
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    console.error('getCarList: Response not okay from server: ', response.statusText);
                    return [];
                }
            })
            .then((data) => {
                return data;
            });
    }

    getCarDetails(id) {
        return fetch('/api/cars/' + id)
            .then((response) => {
                if (response.ok) {
                    return response.json();
                } else {
                    console.error('getCarDetails: Response not okay from server: ', response.statusText);
                    return [];
                }
            })
            .then((data) => {
                return data;
            });
    }
}
