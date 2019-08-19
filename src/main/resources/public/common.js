(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["common"],{

/***/ "./src/app/services/currency.service.ts":
/*!**********************************************!*\
  !*** ./src/app/services/currency.service.ts ***!
  \**********************************************/
/*! exports provided: CurrencyService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CurrencyService", function() { return CurrencyService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm5/index.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");





var CurrencyService = /** @class */ (function () {
    function CurrencyService(_httpClient) {
        this._httpClient = _httpClient;
        this.apiUrl = _environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].api;
        this.httpOptions = {
            headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpHeaders"]({ 'Content-Type': 'application/json; charset=utf-8' })
        };
    }
    CurrencyService.prototype.getAllCurrencies = function (maxSize, field, text) {
        var criteria = {
            field: field,
            text: text.length === 0 ? null : text
        };
        return this._httpClient.post(this.apiUrl + '/currencies/' + maxSize, criteria, this.httpOptions);
    };
    CurrencyService.prototype.getCurrencyById = function (id) {
        return this._httpClient.get(this.apiUrl + '/currency/' + id, this.httpOptions);
    };
    CurrencyService.prototype.handleError = function (errorResponse) {
        if (errorResponse.error instanceof ErrorEvent) {
            console.log('Client Side Error: ', errorResponse.error.message);
        }
        else {
            console.log('Server Side Error: ', errorResponse);
        }
        return rxjs__WEBPACK_IMPORTED_MODULE_3__["Observable"].throw(errorResponse.message || 'Server Error');
    };
    CurrencyService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
            providedIn: 'root'
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]])
    ], CurrencyService);
    return CurrencyService;
}());



/***/ })

}]);
//# sourceMappingURL=common.js.map