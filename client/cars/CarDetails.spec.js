'use strict';

import {CarDetails} from './CarDetails';

describe('CarDetails', function () {
    describe('#getDetails()', function () {
        it('should return the car details in specified format', function () {
            let carDetails = new CarDetails(10004, 'HATCH', 'AUTO',
                            'PREMIUM UNLEADED PETROL');
            expect(carDetails.getDetails()).toEqual(
                                     'ID: 10004 Body types:HATCH Transmission types: AUTO Fuel Types: PREMIUM UNLEADED PETROL');
        });
    });
});
