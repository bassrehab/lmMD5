#!/usr/bin/env bash

multiplier=10240000  # 10 gig
bytesize=1024
filename=mybigfile.txt

dd if=/dev/zero of=${filename} count=${multiplier} bs=${bytesize}
