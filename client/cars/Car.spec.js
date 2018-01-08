'use strict';

import {Car} from './Car';

describe('Car', function () {
    describe('#getDetails()', function () {
        it('should return the car details in specified format', function () {
            let car = new Car(10001, 'Ford', 'Falcon', 20000);
            expect(car.getDetails()).toEqual('Ford Falcon ($20000)');
        });
    });
});
