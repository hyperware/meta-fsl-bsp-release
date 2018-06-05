DESCRIPTION = "A library to retrieve i.MX GPU performance data"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=75abe2fa1d16ca79f87cde926f05f72d"

SRC_URI[arm-fb.md5sum] = "627d47ea5dcb873e4b243bac3242a4bd"
SRC_URI[arm-fb.sha256sum] = "9d2be56052c02ef5597bb247e71d5d7d96df2dc7cdfb484d67ea9548025c51d8"

SRC_URI[arm-wayland.md5sum] = "4edb4f1ae0175a1c2d47ae71440236a3"
SRC_URI[arm-wayland.sha256sum] = "ef6aeb12f3b9667437eb78307a33b0461d6a6d76e9307dd1a93857690b6e5ce8"

SRC_URI[arm-x11.md5sum] = "8a5c088a7291037bf6a4ace109dd4172"
SRC_URI[arm-x11.sha256sum] = "c6ce197ba7ff90c5b51d3c68aeabd10cb842a71ce8d63971c11bd8cddfd2e3c3"

SRC_URI[aarch64-fb.md5sum] = "68c840de8a7737d1f5becb9f3c5b6529"
SRC_URI[aarch64-fb.sha256sum] = "0fbf02e4f707094d0d109dcd5f66130f2e82ec9f0cca3f5cc787624f710fc639"

SRC_URI[aarch64-wayland.md5sum] = "4e1470960cd31352522a316741bf0382"
SRC_URI[aarch64-wayland.sha256sum] = "a030f8f32c0443aa9cfef0a2e275ccfd62c847cf7881ca2bf6995dbf0475a7e9"

SRC_URI[aarch64-x11.md5sum] = "88f611d7c57e6cc9582edc4030c3da24"
SRC_URI[aarch64-x11.sha256sum] = "7305dbaab11328ae201f19918b5f57bcfb3647ba9657fa3fa7fa1cd3cf7f7ce6"

inherit fsl-eula-unpack2 fsl-eula-graphics

PACKAGE_ARCH = "${MACHINE_SOCARCH}"

RDEPENDS_${PN} = "imx-gpu-viv"

# Compatible only with i.MX with GPU
COMPATIBLE_MACHINE        = "(^$)"
COMPATIBLE_MACHINE_imxgpu = "${MACHINE}"
