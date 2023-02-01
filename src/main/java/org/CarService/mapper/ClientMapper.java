package org.CarService.mapper;

import org.CarService.dto.ClientDto;
import org.CarService.entity.Client;
import org.mapstruct.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public interface ClientMapper extends RowMapper<Client> {
    ClientDto ClientToClientDto(Client client);

    Client ClientDtoToClient(ClientDto clientDto);

    @Override
    default Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setIdClient(rs.getInt("id_client"));
        client.setFullName(rs.getString("full_name"));
        client.setUserName(rs.getString("user_name"));
        client.setPassword(rs.getString("password"));
        client.setGender(rs.getString("gender"));
        client.setPhone(rs.getString("phone"));
        return client;
    }
}
