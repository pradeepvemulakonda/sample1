'use strict';

import {CarService} from './CarService';

describe('CarService', () => {
    describe('#getCarList()', () => {
        let carResponsePromise;
        let promiseHelper;

        beforeEach(() => {
            let carService = new CarService();

            let fetchPromise = new Promise(function (resolve, reject) {
                promiseHelper = {
                    resolve: resolve,
                    reject: reject
                };
            });

            spyOn(window, 'fetch').and.returnValue(fetchPromise);
            carResponsePromise = carService.getCarList('fo');
        });

        it('should fetch the car results using the correct API', () => {
            expect(window.fetch).toHaveBeenCalledWith('/api/cars?query=fo');
        });

        it('should return a promise', () => {
            expect(carResponsePromise).toEqual(jasmine.any(Promise));
        });

        describe('on successful fetch', () => {
            let carList = [{
                'id': 10001,
                'makeName': 'Ford',
                'modelName': 'Falcon',
                'rrp': 29890
            }, {
                'id': 10002,
                'makeName': 'Ford',
                'modelName': 'Fiesta',
                'rrp': 15825
            }, {
                'id': 10003,
                'makeName': 'Ford',
                'modelName': 'Focus',
                'rrp': 23390
            }];

            beforeEach(() => {
                let response = new Response(JSON.stringify(carList));

                promiseHelper.resolve(response);
            });

            it('resolves the promise with a list of cars', (done) => {
                carResponsePromise.then((data) => {
                    expect(data).toEqual(carList);
                    done();
                });
            });
        });

        describe('on unsuccessful fetch', () => {
            let errorObj = {
                statusText: 'No cars found'
            };

            beforeEach(() => {
                promiseHelper.reject(errorObj);
            });

            it('rejects it\'s promise with an appropriate error message', (done) => {
                carResponsePromise.catch((data) => {
                    expect(data).toEqual(errorObj);
                    done();
                });
            });
        });
    });

    describe('#getCarDetails()', () => {
      let carDetailsResponsePromise;
      let promiseHelper;

      beforeEach(() => {
          let carDetailsService = new CarService();

          let fetchPromise = new Promise(function (resolve, reject) {
              promiseHelper = {
                  resolve: resolve,
                  reject: reject
              };
          });

          spyOn(window, 'fetch').and.returnValue(fetchPromise);
          carDetailsResponsePromise = carDetailsService.getCarDetails('10004');
      });

      it('should fetch the car details using the correct API', () => {
          expect(window.fetch).toHaveBeenCalledWith('/api/cars/10004');
      });

      it('should return a promise', () => {
          expect(carDetailsResponsePromise).toEqual(jasmine.any(Promise));
      });

      describe('on successful fetch', () => {
          let carDetails = {
              'id': 10004,
              'bodyTypes': ['COUPE'],
              'transmissionTypes': ['AUTO'],
              'fuelTypes': ['PREMIUM UNLEADED PETROL']
          };

          beforeEach(() => {
              let response = new Response(JSON.stringify(carDetails));
              promiseHelper.resolve(response);
          });

          it('resolves the promise with a car details', (done) => {
              carDetailsResponsePromise.then((data) => {
                  expect(data).toEqual(carDetails);
                  done();
              });
          });
      });

      describe('on unsuccessful fetch', () => {
          let errorObj = {
              statusText: 'Car not found'
          };

          beforeEach(() => {
              promiseHelper.reject(errorObj);
          });

          it('rejects it\'s promise with an appropriate error message', (done) => {
              carDetailsResponsePromise.catch((data) => {
                  expect(data).toEqual(errorObj);
                  done();
              });
          });
      });
   });
});
