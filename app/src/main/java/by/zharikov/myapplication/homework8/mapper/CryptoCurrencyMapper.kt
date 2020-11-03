package by.zharikov.myapplication.homework8.mapper

import by.zharikov.myapplication.homework8.dto.CryptoCurrencyResponse
import by.zharikov.myapplication.homework8.entity.CryptoCurrency

class CryptoCurrencyMapper {
    fun convert(from: CryptoCurrencyResponse.Data?): CryptoCurrency {
        return CryptoCurrency(
            cryptoCurrencyName = from?.name.orEmpty(),
            id = from?.id ?: 0,
            percentChange = from?.quote?.uSD?.percentChange1h ?: 0.0,
            priceCryptoCurrency = from?.quote?.uSD?.price ?: 0.0
        )
    }
}