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

public class MegaCoin extends Coin {

    public MegaCoin() {
        super("MegaCoin", "MEC", new MegaCoinAddressValidator());
    }


    public static class MegaCoinAddressValidator extends Base58BitcoinAddressValidator {

        public MegaCoinAddressValidator() {
            super(new MegaCoinParams());
        }

        @Override
        public AddressValidationResult validate(String address) {
            if (!address.matches("^[M][a-km-zA-HJ-NP-Z1-9]{25,34}$"))
                return AddressValidationResult.invalidStructure();

            return super.validate(address);
        }
    }

 /*
 * src/chainparams.cpp
 * PIVX
 * base58Prefixes[PUBKEY_ADDRESS] = std::vector<unsigned char>(1, 30); // 30 => [hex] => 1Exxxx => [Base58 Encode] => Dxxxx
 * base58Prefixes[SCRIPT_ADDRESS] = std::vector<unsigned char>(1, 13); // 13 => [hex] => 0Dxxxx => [Base58 Encode] => 6xxxx
 * 
 * MEC
 * base58Prefixes[PUBKEY_ADDRESS] = std::vector<unsigned char>(1,50); // 50 => [hex] => 32xxxx => [Base58 Encode] => Mxxxx
 * base58Prefixes[SCRIPT_ADDRESS] = std::vector<unsigned char>(1,5); // 5 => [hex] => 05xxxx => [Base58 Encode] => 3xxxx
 * base58Prefixes[SCRIPT_ADDRESS2] = std::vector<unsigned char>(1,50); // 50 => [hex] => 32xxxx => [Base58 Encode] => Mxxxx
 */ 
    public static class MegaCoinParams extends NetworkParametersAdapter {
        
        public MegaCoinParams() {
            addressHeader = 50;
            p2shHeader = 5;
            p2shHeader2 = 50;
            acceptableAddressCodes = new int[]{addressHeader, p2shHeader, p2shHeader2};
        }
    }
}
