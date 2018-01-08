'use strict';

import {CarSearchComponent} from './cars/CarSearchComponent';
import {CarDetailsComponent} from './cars/CarDetailsComponent';

(() => {
    let NewCarSearchComponent = document.registerElement('car-search', CarSearchComponent);
    let NewCarDetailsComponent = document.registerElement('car-details', CarDetailsComponent);
})();