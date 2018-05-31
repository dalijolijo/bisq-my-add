/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package bisq.asset.coins;

import bisq.asset.AddressValidationResult;
import bisq.asset.Base58BitcoinAddressValidator;
import bisq.asset.Coin;
import bisq.asset.NetworkParametersAdapter;

public class Diamond extends Coin {

    public Diamond() {
        super("Diamond", "DMD", new DiamondAddressValidator());
    }


    public static class DiamondAddressValidator extends Base58BitcoinAddressValidator {

        public DiamondAddressValidator() {
            super(new DiamondParams());
        }

        @Override
        public AddressValidationResult validate(String address) {
            if (!address.matches("^[d][a-km-zA-HJ-NP-Z1-9]{25,34}$"))
                return AddressValidationResult.invalidStructure();

            return super.validate(address);
        }
    }

 /*
 * src/chainparams.cpp
 * PIVX
 * base58Prefixes[PUBKEY_ADDRESS] = std::vector<unsigned char>(1, 30); //0x1E
 * base58Prefixes[SCRIPT_ADDRESS] = std::vector<unsigned char>(1, 13); //0x0D
 * 
 * DMD
 * base58Prefixes[PUBKEY_ADDRESS] = std::vector<unsigned char>(1, 90); //0x5A
 * base58Prefixes[SCRIPT_ADDRESS] = std::vector<unsigned char>(1, 8);  //0x08
 */ 
    public static class DiamondParams extends NetworkParametersAdapter {
        
        public DiamondParams() {
            addressHeader = 90; //PIVX 30
            p2shHeader = 8; //PIVX 13
            acceptableAddressCodes = new int[]{addressHeader, p2shHeader};
        }
    }
}
