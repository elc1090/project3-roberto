package mapper;

import com.roberto.greenhousing.dto.PlantDto;
import com.roberto.greenhousing.entity.Plant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PlantMapper {

    @Mapping(source = "speciesId", target = "species.id")
    Plant toPlant(PlantDto plantDto);

    @Mapping(source = "species.id", target = "speciesId")
    PlantDto fromPlant(Plant plant);

    List<PlantDto> fromPlant(List<Plant> plant);

}
