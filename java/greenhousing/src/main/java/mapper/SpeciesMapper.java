package mapper;

import com.roberto.greenhousing.dto.SpeciesDto;
import com.roberto.greenhousing.entity.Species;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SpeciesMapper {

    Species toSpecies(SpeciesDto speciesDto);

    SpeciesDto fromSpecies(Species species);

    List<SpeciesDto> fromSpecies(List<Species> species);

}
