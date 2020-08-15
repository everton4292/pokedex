import com.pessoadev.pokedexproject.commons.NetworkModule


class DetailsRepository{

    private val service = NetworkModule().getDetailsService()

    suspend fun getPokeDetails(): PokeDetailsResponse = service.getPokeDetails("ditto")
}