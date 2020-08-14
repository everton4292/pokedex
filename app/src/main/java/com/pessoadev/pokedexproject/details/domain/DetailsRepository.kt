import com.pessoadev.pokedexproject.commons.NetworkModule
import com.pessoadev.pokedexproject.list.model.PokeListResponse

class DetailsRepository{

    private val service = NetworkModule().getDetailsService()

    suspend fun getPokeDetails(): PokeDetailsResponse = service.getPokeDetails("ditto")
}