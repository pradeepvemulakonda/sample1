'use strict';

export class Car {
    constructor(id, makeName, modelName, rrp) {
        this._id = id;
        this._makeName = makeName;
        this._modelName = modelName;
        this._rrp = rrp;
    }

    get id() {
        return this._id;
    }

    getDetails() {
        return `${this._makeName} ${this._modelName} (\$${this._rrp})`;
    }
}
