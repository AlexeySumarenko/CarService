import http from "../http-common";

class ProducerService{
    getAll() {
        return http.get("/producers");
    }

    get(id) {
        return http.get(`/producers/${id}`);
    }

    create(data) {
        return http.post("/producers", data);
    }

    update(id, data) {
        return http.put(`/producers/${id}`, data);
    }

    delete(id) {
        return http.delete(`/producers/${id}`);
    }

    deleteAll() {
        return http.delete(`/producers`);
    }

    findByName(name) {
        return http.get(`/producers?title=${name}`);
    }
}
export default new ProducerService()