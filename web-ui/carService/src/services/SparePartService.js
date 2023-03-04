import http from "../http-common";

class SparePartService{
    getAll() {
        return http.get("/spareParts");
    }

    get(id) {
        return http.get(`/spareParts/${id}`);
    }

    create(data) {
        return http.post("/spareParts", data);
    }

    update(id, data) {
        return http.put(`/spareParts/${id}`, data);
    }

    delete(id) {
        return http.delete(`/spareParts/${id}`);
    }

    deleteAll() {
        return http.delete(`/spareParts`);
    }

    findByName(name) {
        return http.get(`/spareParts?title=${name}`);
    }
}
export default new SparePartService()