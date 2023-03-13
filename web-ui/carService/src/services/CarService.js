import http from "../http-common";

class CarService{
    getAll(currentPage, quantity) {
        return http.get(`/cars`, {
            params: {
                pageNumber: currentPage,
                quantity: quantity
            }
        });
    }

    get(id) {
        return http.get(`/cars/${id}`);
    }

    create(data) {
        return http.post("/cars", data);
    }

    update(id, data) {
        return http.put(`/cars/${id}`, data);
    }

    delete(id) {
        return http.delete(`/cars/${id}`);
    }

    deleteAll() {
        return http.delete(`/cars`);
    }

    findByName(name) {
        return http.get(`/cars?title=${name}`);
    }
}
export default new CarService()