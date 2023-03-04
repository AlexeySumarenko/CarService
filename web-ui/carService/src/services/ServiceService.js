import http from "../http-common";

class ServiceService{
    getAll() {
        return http.get("/services");
    }

    get(id) {
        return http.get(`/services/${id}`);
    }

    create(data) {
        return http.post("/services", data);
    }

    update(id, data) {
        return http.put(`/services/${id}`, data);
    }

    delete(id) {
        return http.delete(`/services/${id}`);
    }

    deleteAll() {
        return http.delete(`/services`);
    }

    findByName(name) {
        return http.get(`/services?title=${name}`);
    }
}
export default new ServiceService()