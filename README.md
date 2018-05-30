# Add following coins to bisq

## BitCloud 
BTDX
https://bit-cloud.info
https://chainz.cryptoid.info/btdx
https://github.com/LIMXTEC/Bitcloud

## Diamond
DMD
https://bit.diamonds
https://chainz.cryptoid.info/dmd
https://github.com/LIMXTEC/DMDv3

## MegaCoin
MEC
https://www.megacoin.eu
https://chainz.cryptoid.info/mec
https://github.com/LIMXTEC/Megacoin


# How to list an asset
See https://github.com/bisq-network/bisq-docs/blob/master/exchange/howto/list-asset.adoc

## Step 0.
Fork https://github.com/dalijolijo/bisq-assets

__Create dedicated branch in your fork:__
* list-foo-asset
* list-bitcloud-coin

## Step 1. Implement your asset
Coin implementations must be located within the ``bisq.asset.coins`` package.
Fully-qualified name should be: ``bisq.asset.coins.BitCloud``

## Step 2. Register your asset
Adding __alphabetical__ an entry to the ``META-INF/services/bisq.asset.Asset`` provider-configuration file.

## Step 3. Write tests for your asset (bisq-assets/src/test/java/bisq/asset/coins/)
Create a new ``AbstractAssetTest`` subclass for your asset, named e.g. ``FooCoinTest`` and implement the required methods as appropriate.

## Step 4. Compile and test everything
```
./gradlew build
[...]
BUILD SUCCESSFUL
```

## Step 5. Create a well-formed Git commit
__Single Commit Message:__
```List BitCloud (BTDX)```

Git author metadata with ```git log```
```
Author: David xy <david.xy@zzz.net>
Date:   Wed Aug 1 00:00:00 1979 -0800
```

## Step 6. Submit your pull request
Pull Request to bisq-network/bisq-assets repository’s master branch
Important: Check the "Allow edits from maintainers" box in pull requests (see https://github.com/bisq-network/style/issues/4)

__Pull request message:__
```
- Official project URL: [url]
- Official block explorer URL: [url]
```
Example
```
- Official project URL: https://bit-cloud.info
- Official block explorer URL: https://chainz.cryptoid.info/btdx
```
